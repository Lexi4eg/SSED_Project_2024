namespace SWP_Project_2024.Pages;

public class QuestionLeaderboard
{
    public long Id { get; set; }
    public String username { get; set; }
    public int score { get; set; }
    
    public QuestionLeaderboard(long id, String username, int score)
    {
        this.Id = id;
        this.username = username;
        this.score = score;
    }
    
    public QuestionLeaderboard()
    {
        
    }
    
}