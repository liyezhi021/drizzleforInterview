package com.example.entity;

public class Drizzle {
    private Integer iddrizzle;

    private String drizzlecol;

    private String drizzlecol1;

    private String drizzlecol2;

    public Integer getIddrizzle() {
        return iddrizzle;
    }

    public void setIddrizzle(Integer iddrizzle) {
        this.iddrizzle = iddrizzle;
    }

    public String getDrizzlecol() {
        return drizzlecol;
    }

    public void setDrizzlecol(String drizzlecol) {
        this.drizzlecol = drizzlecol == null ? null : drizzlecol.trim();
    }

    public String getDrizzlecol1() {
        return drizzlecol1;
    }

    @Override
    public String toString() {
        return "Drizzle{" +
                "iddrizzle=" + iddrizzle +
                ", drizzlecol='" + drizzlecol + '\'' +
                ", drizzlecol1='" + drizzlecol1 + '\'' +
                ", drizzlecol2='" + drizzlecol2 + '\'' +
                '}';
    }

    public void setDrizzlecol1(String drizzlecol1) {
        this.drizzlecol1 = drizzlecol1 == null ? null : drizzlecol1.trim();
    }

    public String getDrizzlecol2() {
        return drizzlecol2;
    }

    public void setDrizzlecol2(String drizzlecol2) {
        this.drizzlecol2 = drizzlecol2 == null ? null : drizzlecol2.trim();
    }
}