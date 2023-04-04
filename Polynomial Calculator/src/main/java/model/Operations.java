package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Operations {

    private static List<String> getMonomialsAsString(String polynomial) {
        List<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("-?\\d*(x(\\^\\d+)*)*");
        Matcher matcher = pattern.matcher(polynomial);
        while (matcher.find()) {
            String matchResult = matcher.group();
            if (!matchResult.equals("")) {
                list.add(matchResult);
            }
        }
        return list;
    }

    private Monomial getMonomialFromString(String monomialString) {
        if (monomialString.endsWith("x") && monomialString.length() > 1) {
            return new Monomial(Integer.parseInt(monomialString.substring(0, monomialString.length() - 1)), 1);
        }
        String[] splitMonomial = monomialString.split("x\\^*");
        if (splitMonomial.length == 0) {
            return new Monomial(1, 1);
        }
        if (splitMonomial.length == 1) {
            return new Monomial(Integer.parseInt(splitMonomial[0]), 0);
        }
        if (splitMonomial.length == 2) {
            int coef = (splitMonomial[0].equals("")) ? 1 : Integer.parseInt(splitMonomial[0]);
            int power = (splitMonomial[1].equals("")) ? 0 : Integer.parseInt(splitMonomial[1]);

            return new Monomial(coef, power);

        }
        return null;
    }

    private List<Monomial> getMonomials(String polynomial) {
        List<String> monomialsString = getMonomialsAsString(polynomial);
        List<Monomial> monomials = new ArrayList<>();
        for (String s : monomialsString) {
            monomials.add(getMonomialFromString(s));
        }
        return monomials;
    }

    public Polynomial getPolynomial(String polynomial) {
        return new Polynomial(getMonomials(polynomial));
    }


    public Polynomial add(Polynomial p1, Polynomial p2) {

        List<Monomial> result = new ArrayList<>();
        List<Monomial> l1 = p1.getMonomials();
        List<Monomial> l2 = p2.getMonomials();

        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            Monomial m1 = l1.get(i);
            Monomial m2 = l2.get(j);
            if (m1.getPower() == m2.getPower()) {
                Monomial m = new Monomial(m1.getCoef() + m2.getCoef(), m1.getPower());
                result.add(m);
                i++;
                j++;
            }
            if (m1.getPower() > m2.getPower()) {
                result.add(m1);
                i++;
            }
            if (m1.getPower() < m2.getPower()) {
                result.add(m2);
                j++;
            }
        }
        while (i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }
        return new Polynomial(result);
    }

    public Polynomial substract(Polynomial p1, Polynomial p2) {

        List<Monomial> result = new ArrayList<>();
        List<Monomial> l1 = p1.getMonomials();
        List<Monomial> l2 = p2.getMonomials();

        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            Monomial m1 = l1.get(i);
            Monomial m2 = l2.get(j);
            if (m1.getPower() == m2.getPower()) {
                Monomial m = new Monomial(m1.getCoef() - m2.getCoef(), m1.getPower());
                if (m.getCoef() != 0) {
                    result.add(m);
                }
                i++;
                j++;

            }
            if (m1.getPower() > m2.getPower()) {
                result.add(m1);
                i++;
            }
            if (m1.getPower() < m2.getPower()) {
                result.add(m2);
                j++;
            }
        }
        while (i < l1.size()) {
            result.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            result.add(l2.get(j));
            j++;
        }
        return new Polynomial(result);
    }

    public List<Polynomial> divide(Polynomial p1, Polynomial p2) {

        Operations operations = new Operations();
        List<Polynomial> result = new ArrayList<>();
        List<Monomial> divideResult = new ArrayList<>();
        List<Monomial> l1 = p1.getMonomials();
        List<Monomial> l2 = p2.getMonomials();

        Polynomial q = new Polynomial();
        Polynomial r = p1;
        Polynomial t = new Polynomial();
        if (l2.size() != 0) {


            while ( r.getMonomials().get(0).getPower() >= l2.get(0).getPower()) {
                Monomial m1 = r.getMonomials().get(0);
                Monomial m2 = l2.get(0);

                Monomial m;
                if ((m2.getCoef() != 0 && m2.getPower() != 0)) {
                    m = new Monomial(m1.getCoef() / m2.getCoef(), m1.getPower() - m2.getPower());
                } else break;

                q.getMonomials().add(m);

                System.out.println(q.toString());
                System.out.println(r.toString());
                r = operations.substract(r, operations.multiplication(p2, m));

                if(r.getMonomials().size() == 0){
                    break;
                }
            }
        }
        result.add(q);
        result.add(r);
        return result;
    }


    public Polynomial multiplication(Polynomial p1, Polynomial p2) {

        List<Monomial> result = new ArrayList<>();
        List<Monomial> multiplicationResult = new ArrayList<>();
        List<Monomial> l1 = p1.getMonomials();
        List<Monomial> l2 = p2.getMonomials();

        for (Monomial m1 : p1.getMonomials())
            for (Monomial m2 : p2.getMonomials()) {
                Monomial m = new Monomial(m1.getCoef() * m2.getCoef(), m1.getPower() + m2.getPower());
                multiplicationResult.add(m);
            }

        for (Monomial m1 : multiplicationResult) {
            boolean hasPower = false;
            for (Monomial m2 : result) {
                if (m1.getPower() == m2.getPower()) {
                    m2.setCoef(m1.getCoef() + m2.getCoef());
                    hasPower = true;
                }
            }
            if (!hasPower) {
                result.add(m1);
            }
        }
        return new Polynomial(result.stream().sorted(Comparator.comparingInt(Monomial::getPower).reversed()).collect(Collectors.toList()));
    }

    public Polynomial multiplication(Polynomial p1, Monomial m2) {

        List<Monomial> result = new ArrayList<>();
        List<Monomial> multiplicationResult = new ArrayList<>();

        Monomial m = null;
        for (Monomial m1 : p1.getMonomials()) {
            m = new Monomial(m1.getCoef() * m2.getCoef(), m1.getPower() + m2.getPower());
            multiplicationResult.add(m);
        }
        return new Polynomial(multiplicationResult);
    }


    public Polynomial derivative(Polynomial p) {

        List<Monomial> result = new ArrayList<>();
        for (Monomial m : p.getMonomials()) {
            if (m.getPower() != 0) {
                result.add(new Monomial(m.getCoef() * m.getPower(), m.getPower() - 1));
            }
        }
        return new Polynomial(result);

    }

    public Polynomial integration(Polynomial p) {

        List<Monomial> result = new ArrayList<>();
        for (Monomial m : p.getMonomials()) {
            if (m.getPower() != 0) {
                result.add(new Monomial((m.getCoef() / (m.getPower() + 1)), m.getPower() + 1));
            } else
                result.add(new Monomial(m.getCoef(), 1));
        }
        return new Polynomial(result);
    }

}

