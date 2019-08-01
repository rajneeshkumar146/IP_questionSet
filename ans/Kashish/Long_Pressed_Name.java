package InternQuestAS1;

import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl.Type;

public class Long_Pressed_Name {
	public static boolean isLongPressedName(String name, String typed) {
		if (typed.length() == 0 || name.length() == 0) {
			return false;
		}
		int idxname = 0;
		int idxtype = 0;
		while (idxname < name.length()) {
			if (idxtype >= typed.length()) {
				return false;
			}
			if (name.charAt(idxname) == typed.charAt(idxtype)) {
				idxname++;
				idxtype++;
			} else {
				if (idxname>0 && idxtype < typed.length() && name.charAt(idxname - 1) == typed.charAt(idxtype)) {
					idxtype++;
				} else {
					return false;
				}

			}

		}

		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String name = "saeed";

		String typed = "ssaaedd";
		System.out.println(isLongPressedName(name, typed));

	}

}
