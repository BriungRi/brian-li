package rational;

public class Rational {
	private int numerator, denominator;

	public Rational(int num, int den) {
		if (den == 0)
			den = 1;
		this.numerator = num;
		this.denominator = den;
		fixNegative();
		reduce();
	}

	private void fixNegative() {
		if ((numerator > 0 && denominator < 0)
				|| (numerator < 0 && denominator < 0)) {
			this.numerator = this.numerator * -1;
			this.denominator = this.denominator * -1;
		}
	}

	public void reduce() {
		int gcf = gcf(numerator, denominator, denominator);
		while (gcf != 1) {
			this.numerator = numerator / gcf;
			this.denominator = denominator / gcf;
			gcf = gcf(numerator, denominator, denominator);
		}
	}

	public int gcf(int num, int den, int guess) {
		if (num % guess == 0 && den % guess == 0)
			return guess;
		else
			return gcf(num, den, guess - 1);
	}

	public int lcd(int den1, int den2, int guess) {
		while (!(guess % den1 == 0 && guess % den2 == 0)) {
			guess++;
		}
		return guess;
	}

	public Rational add(Rational r) {
		int lcd = lcd(r.getDenominator(), this.denominator,
				Math.min(r.getDenominator(), this.denominator));
		return new Rational(r.getNumerator() * (lcd / r.getDenominator())
				+ this.numerator * (lcd / this.denominator), lcd);
	}
	

	public Rational subtract(Rational r) {
		int lcd = lcd(r.getDenominator(), this.denominator,
				Math.max(r.getDenominator(), this.denominator));
		return new Rational(this.numerator * (lcd / this.denominator) 
				- r.getNumerator() * (lcd / r.getDenominator()), lcd);
	}

	public Rational multiply(Rational r) {
		return new Rational(r.getNumerator() * numerator, r.getDenominator()
				* denominator);
	}

	public Rational divide(Rational r) {
		return new Rational(numerator * r.getDenominator(), denominator
				* r.getNumerator());
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals(Object o) {
		try {
			return ((Rational) o).getNumerator() == numerator
					&& ((Rational) o).getDenominator() == denominator;
		} catch (ClassCastException e) {
			e.printStackTrace();
			return false;
		}
	}

	private double getValue() {
		return (double) numerator / (double) denominator;
	}

	public int compareTo(Object o) {
		try {
			Rational r = (Rational) o;
			if (this.equals(r)) {
				return 0;
			} else if (this.getValue() < r.getValue()) {
				return -1;
			} else
				return 1;
		} catch (ClassCastException e) {
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
	}

	public Rational recipricoal() {
		return new Rational(this.denominator, this.numerator);
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

}
