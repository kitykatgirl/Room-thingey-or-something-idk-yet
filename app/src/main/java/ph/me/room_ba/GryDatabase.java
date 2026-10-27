package ph.me.room_ba;

import androidx.room3.Database;
import androidx.room3.RoomDatabase;

@Database(entities = {Gra.class}, version = 1)
public abstract class GryDatabase extends RoomDatabase {
    public abstract GraDAO zwrocGryDAO();
}
