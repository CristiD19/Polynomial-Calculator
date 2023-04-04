package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polynomial {
    private List<Monomial> monomials = new ArrayList<>();

    public Polynomial() {}

    public Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Monomial m : monomials) {
            if (m.getCoef() >= 0) {
                builder.append("+");
            }
            builder.append(m);
        }
        String result = builder.toString();
        if (result.startsWith("+")) {
            return result.substring(1);
        }
        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        boolean res1 = monomials.containsAll(that.getMonomials());
        boolean res2 = that.getMonomials().containsAll(monomials);
        return res1 && res2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }
}
