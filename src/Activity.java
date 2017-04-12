
public enum Activity {
	SOFTDRINK (-1),
	MILK (0.2),
	WATER (0.1),
	COFFEE_ICED (-0.4),
	COFFEE_HOT (0),
	ALCOHOL (-1.2),
	HEALTHY_DRINK (0.4),
	UNHEALTHY_DRINK (-0.7),
	CHICKEN (0.7),
	FAT_CHICKEN (-0.25),
	BEEF (0.5),
	FAT_BEEF (-0.25),
	PORK (0.5),
	FAT_PORK (-0.6),
	VEGETABLE (0.6),
	FISH (0.6),
	RICE (0.2),
	BREAD (0.2),
	HEALTHY_FOOD (0.3),
	UNHEALTHY_FOOD (-0.5),
	CHEAT_FOOD (-1.5),
	GYM_CARDIO (2.5),
	GYM_LIFTING (2),
	WALKING (0.2),
	SITTING (-0.1),
	STANDING (0.1),
	HOUSEWORK (0.2);
		
	private final double rating;
	Activity(double rating){
			this.rating = rating;
	}
}
