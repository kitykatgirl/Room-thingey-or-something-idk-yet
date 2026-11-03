package ph.me.room_ba;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDodaj;
    EditText editTextNazwa, editTextMin, editTextMax, editTextKatWiekowa;
    Spinner spinnerKategoria;
    ListView listView;
    List<Gra> gryList;
    ArrayAdapter<Gra> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnDodaj = findViewById(R.id.button);
        editTextNazwa = findViewById(R.id.editTextNazwa);
        editTextMin = findViewById(R.id.editTextMinOsob);
        editTextMax = findViewById(R.id.editTextMaxOsob);
        editTextKatWiekowa = findViewById(R.id.editTextKatWiekowa);
        spinnerKategoria = findViewById(R.id.spinnerKategoria);
        listView = findViewById(R.id.listView);

        GryDatabase gryDatabase = Room.databaseBuilder(getApplicationContext(), GryDatabase.class,"gry_db").allowMainThreadQueries().build();

        gryList = gryDatabase.zwrocGryDAO().zwrocWszystkieGry();
        adapter = new ArrayAdapter<Gra>(this, android.R.layout.simple_list_item_1, gryList);
        listView.setAdapter(adapter);

        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gra gra = new Gra(
                        editTextNazwa.getText().toString(),
                        spinnerKategoria.getSelectedItem().toString(),
                        Integer.parseInt(editTextMin.getText().toString()),
                        Integer.parseInt(editTextMax.getText().toString()),
                        Integer.parseInt(editTextKatWiekowa.getText().toString())
                );
                gryDatabase.zwrocGryDAO().wstawGreDoBazy(gra);
                gryList.add(gra);
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                gryDatabase.zwrocGryDAO().usunZBazy(gryList.get(i));
                gryList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
}