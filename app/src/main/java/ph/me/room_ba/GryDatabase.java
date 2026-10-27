package ph.me.room_ba;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Gra.class}, version = 1)
public abstract class GryDatabase extends RoomDatabase {
    public abstract GraDAO zwrocGryDAO();
}
