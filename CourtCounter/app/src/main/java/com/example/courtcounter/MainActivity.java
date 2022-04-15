package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int team_a_score=0;
    int team_b_score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addOneForTeamA(View view){
        team_a_score+=1;
        displayForTeamA(team_a_score);
    }
    public void addTwoForTeamA(View view){
        team_a_score+=2;
        displayForTeamA(team_a_score);
    }
    public void addThreeForTeamA(View view){
        team_a_score+=3;
        displayForTeamA(team_a_score);
    }

    public void displayForTeamA(int number){
        TextView TeamA = (TextView) findViewById(R.id.team_a_score);
        TeamA.setText(""+number);
    }

    public void addOneForTeamB(View view){
        team_b_score+=1;
        displayForTeamB(team_b_score);
    }
    public void addTwoForTeamB(View view){
        team_b_score+=2;
        displayForTeamB(team_b_score);
    }
    public void addThreeForTeamB(View view){
        team_b_score+=3;
        displayForTeamB(team_b_score);
    }

    public void displayForTeamB(int number){
        TextView TeamB = (TextView) findViewById(R.id.team_b_score);
        TeamB.setText(""+number);
    }

    public void Reset(View view){
        TextView TeamA = (TextView) findViewById(R.id.team_a_score);
        TextView TeamB = (TextView) findViewById(R.id.team_b_score);
        team_b_score=0;
        team_a_score=0;
        displayForTeamA(team_a_score);
        displayForTeamB(team_b_score);
    }
}