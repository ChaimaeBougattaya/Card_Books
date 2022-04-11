package tp.model.bo;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable,Comparable{
	
	private String SBN;
	private String title;
	private double price;
	//private int quantite;
	
	//Constructors
	
	public Book() {
	}
	public Book(String sbn ,String title, double price) {
		this.SBN=sbn;
		this.title = title;
		this.price = price;
	}
	
	/// getters & setters
	public String getSBN() {
		return SBN;
	}
	
	public void setSBN(String sBN) {
		SBN = sBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [SBN=" + SBN + ", title=" + title + ", price=" + price +"]";
	}
	@Override
	public int compareTo(Object o) {
		return stringCompare(this.SBN,((Book)o).getSBN());
	}
	public static int stringCompare(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }else {
            return 0;
        }
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(SBN, other.SBN) && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title);
	}
}
	
