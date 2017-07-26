package studentScore;

/**
 * Created by rsma on 26/07/2017.
 */
public class Score {

    private int programmingScore;
    private int englishScore;
    private int languageScore;
    private int mathScore;
    private int totalScore;
    private double averageScore;

    public Score(int mathScore, int languageScore, int englishScore, int programmingScore) {
        this.mathScore = mathScore;
        this.languageScore = languageScore;
        this.englishScore = englishScore;
        this.programmingScore = programmingScore;
        calcTotalScore(mathScore,languageScore,englishScore,programmingScore);
        calcAverageScore();
    }

    private void calcTotalScore(int mathScore, int languageScore, int englishScore, int programmingScore) {
        this.totalScore = mathScore + languageScore + englishScore + programmingScore;
    }

    private void calcAverageScore() {
        this.averageScore = (double)this.totalScore/4;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getLanguageScore() {
        return languageScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getProgrammingScore() {
        return programmingScore;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()){
            return false;
        }
        if(this.programmingScore == ((Score)obj).getProgrammingScore()){
            if(this.mathScore == ((Score)obj).getMathScore()){
                if(this.languageScore == ((Score)obj).getLanguageScore()){
                    if(this.englishScore == ((Score)obj).getEnglishScore()){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
