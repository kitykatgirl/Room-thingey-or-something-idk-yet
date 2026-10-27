package ph.me.room_ba;

import androidx.room3.Dao;
import androidx.room3.Delete;
import androidx.room3.Insert;
import androidx.room3.Query;
import androidx.room3.Update;

import java.util.List;

@Dao//Ming
public interface GraDAO {
    @Insert
    public void WstawGreDoBazy(Gra gra);

    @Insert
    public void WstawGryDoBazy(Gra... gry);

    @Delete
    public void usunZBazy(Gra gra);

    @Update
    public void aktualizujGre(Gra gra);

    @Query("SELECT * FROM gry")
    public List<Gra> zwrocWszystkieGry();

    @Query("SELECT nazwa FROM gry WHERE minLiczbaOsob = :ile")
    public List<String> zwrocNazwyPoMinLiczbieOsob(int ile);
}