package Words;



public class Words {
    private  String TV;
    private String TA;
    public String getTV() {
        return TV;
    }
    public Words(String TA, String TV ) {

            this.TV= TV;
            this.TA= TA;

    }
    public void setTV(String TV) {
        this.TV = TV;
    }

    public String getTA() {
        return TA;
    }

    public void setTA(String TA) {
        this.TA = TA;
    }


    public String toString() {
        String t = "| "+TA;
        for (int i= 0; i< 15- TA.length(); i++)
        {
            t+=" ";
        }
        return  t+"|"+ TV;
    }

    public void swap(Words words) {
        String temp;
        temp = this.TA;
        this.TA = words.getTA();
        words.setTA(temp);
        temp = this.TV;
        this.TV = words.getTV();
        words.setTV(temp);
    }
}


