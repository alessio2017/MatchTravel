package matchtravel.com.matchtravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SurveyActivity extends AppCompatActivity {
    private ImageView SeaLake;
    private ImageView Mountain;
    private ImageView Art;
    private ImageView Romantic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        SeaLake = (ImageView) findViewById(R.id.sea_lake_1);
        Mountain = (ImageView) findViewById(R.id.mountain_1);
        Art = (ImageView) findViewById(R.id.art_1);
        Romantic = (ImageView) findViewById(R.id.romantic_1);
        SeaLake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* qui va gestito l'intent che porta all'activity per la seconda domanda

                 */
            }
        });
        Mountain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* qui va gestito l'intent che porta all'activity per la seconda domanda

                 */
            }
        });
        Art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* qui va gestito l'intent che porta all'activity per la seconda domanda

                 */
            }
        });
        Romantic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* qui va gestito l'intent che porta all'activity per la seconda domanda

                 */
            }
        });
    }
}
