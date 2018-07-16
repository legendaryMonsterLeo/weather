
public class Question {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpta() {
		return opta;
	}

	public void setOpta(String a) {
		this.opta = a;
	}
	
	public String getOptb() {
		return optb;
	}

	public void setOptb(String b) {
		this.optb = b;
	}

	public String getOptc() {
		return optc;
	}

	public void setOptc(String c) {
		this.optc = c;
	}

	public String getOptd() {
		return optd;
	}

	public void setOptd(String d) {
		this.optd = d;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String a) {
		this.answer = a;
	}



	

	public String id;
	public String question;
	public String opta;
	public String optb;
	public String optc;
	public String optd;
	public String answer;
	
	public Question() {
		
	}
	public Question(String id, String question, String a, String b, String c,String d,String e) {
		this.id = id;
		this.question = question;
		this.opta = a;
		this.optb = b;
		this.optc = c;
		this.optd = d;
		this.answer =e;
	}
	public static void main(String[] args) {
		

	}

}
