package ph.me.room_ba;

import androidx.room3.Entity;
import androidx.room3.PrimaryKey;

@Entity(tableName = "gry") // verity
public class Gra {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String tytul, kategoria;
    public int minLiczbaOsob, maxLiczbaOsob, kategoriaWiekowa;

    public Gra(String tytul, String kategoria, int minLiczbaOsob, int maxLiczbaOsob, int kategoriaWiekowa) {
        this.tytul = tytul;
        this.kategoria = kategoria;
        this.minLiczbaOsob = minLiczbaOsob;
        this.maxLiczbaOsob = maxLiczbaOsob;
        this.kategoriaWiekowa = kategoriaWiekowa;
    }
}
