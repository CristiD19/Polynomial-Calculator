package model;

import java.util.Objects;

public class Monomial {
    private float coef;
    private int power;

    public Monomial(float coef, int power) {
        this.coef = coef;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (coef != 0) {
            if (coef == (long) coef)
                stringBuilder.append(String.format("%d", (long) coef));
            else
                stringBuilder.append(String.format("%s", coef));
        }
        if (power != 0) {
            stringBuilder.append("x^");
            stringBuilder.append(power);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return Float.compare(monomial.coef, coef) == 0 && power == monomial.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef, power);
    }
}
