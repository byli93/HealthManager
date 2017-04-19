
public enum Activity {
	TEA(0,0.2),
	SOFTDRINK (1,-1),
	MILK (2,0.2),
	WATER (3,0.1),
	COFFEE_ICED (4,-0.4),
	COFFEE_HOT (5,0),
	ALCOHOL (6,-1.2),
	HEALTHY_DRINK (7,0.4),
	UNHEALTHY_DRINK (8,-0.7),
	CHICKEN (9,0.7),
	FAT_CHICKEN (10,-0.25),
	BEEF (11,0.5),
	FAT_BEEF (12,-0.25),
	PORK (13,0.5),
	FAT_PORK (14,-0.6),
	VEGETABLE (15,0.6),
	FISH (16,0.6),
	RICE (17,0.2),
	BREAD (18,0.2),
	HEALTHY_FOOD (19,0.3),
	UNHEALTHY_FOOD (20,-0.5),
	CHEAT_FOOD (21,-1.5),
	GYM_CARDIO (22,2.5),
	GYM_LIFTING (23,2),
	WALKING (24,0.2),
	SITTING (25,-0.1),
	STANDING (26,0.1),
	HOUSEWORK (27,0.2);
		
	private final double rating;
	private final int order;
	Activity(int order , double rating){
			this.order = order;
			this.rating = rating;
	}
	public double rating(){
		return rating;
	}
	public int order(){
		return order;
	}
}
