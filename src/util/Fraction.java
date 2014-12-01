package util;

import java.math.BigInteger;

public class Fraction {
	
	private static final BigInteger bigOne = new BigInteger("1");
	private static final BigInteger bigZero = new BigInteger("0");
	
	private BigInteger n;
	private BigInteger d;
	
	public Fraction(BigInteger n, BigInteger d) {
		if(d.compareTo(bigZero) < 0) {
			d = d.negate();
			n = n.negate();
		}
		BigInteger gcd = n.gcd(d);
		if(gcd.compareTo(bigOne) == 0) {
			this.n = n;
			this.d = d;
		} else {
			this.n = n.divide(gcd);
			this.d = d.divide(gcd);
		}
	}
	
	public Fraction(String n, String d) {
		this(new BigInteger(n), new BigInteger(d));
	}
	
	public Fraction add(Fraction that) {
		return new Fraction(
					this.n.multiply(that.d).add(that.n.multiply(this.d)),
					this.d.multiply(that.d)
				); 
	}
	public Fraction subtract(Fraction that) {
		return new Fraction(
					this.n.multiply(that.d).subtract(that.n.multiply(this.d)),
					this.d.multiply(that.d)
				); 
	}
	
	public Fraction multiply(Fraction that) {
		return new Fraction(
					this.n.multiply(that.n),
					this.d.multiply(that.d)
				); 
	}
	
	public Fraction divide(Fraction that) {
		return new Fraction(
					this.n.multiply(that.d),
					this.d.multiply(that.n)
				); 
	}
	
	public Fraction pow(Fraction that) {
		if(that.d.compareTo(bigOne) != 0){
			System.out.println("Fractional exponents are not currently supported.");
			throw new Error("Fractional exponents are not currently supported.");
		}
		return new Fraction(this.n.pow(that.n.intValue()), this.d.pow(that.n.intValue()));
	}
	
	public boolean equals(Fraction that) {
		return this.n.compareTo(that.n) == 0 && this.d.compareTo(that.d) == 0; 
	}
	
	public String toString() {
		if(this.d.compareTo(bigOne) == 0){ // if it's a whole number (like 110929423)
			return this.n.toString();
		} else {
			BigInteger integerPart = this.n.divide(this.d);
			BigInteger modulusPart = this.n.abs().mod(this.d);
			boolean negative = this.n.compareTo(bigZero) < 0; 
			if(integerPart.compareTo(bigZero) == 0){ // if it's just a fraction, no prefixed number.
				return (negative ? "-" : "") + modulusPart + "/" + this.d;
			} else { // otherwsie it's a mixed number and fraction
				return (negative ? "-" : "") + integerPart.abs() + "_" + modulusPart + "/" + this.d; 
			}
		}
	}
}
