import java.util.ArrayList;
import java.util.List;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        // your code
        double[] calculatedGrades = new double[studentsGrades.length];
        double grandTotal = 0;
        int counter = 0;
        for (char[] myGrades :
                studentsGrades) {
            for (char grade :
                    myGrades) {
                if (grade == 'A'){
                    grandTotal += 4;
                }
                else if (grade == 'B'){
                    grandTotal += 3;
                }
                else if (grade == 'C'){
                    grandTotal += 2;
                }
            }
            grandTotal = grandTotal / myGrades.length;
            calculatedGrades[counter] = grandTotal;
            counter++;
        }
        return calculatedGrades;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if (lower <= 0 || higher <= 0 || studentIdList.length == 0 || studentsGrades.length == 0 || lower > higher){
            return null;
        }
        // invoke calculateGPA
        double[] temporalResultArray = calculateGPA(studentIdList, studentsGrades);
        int counter = 0;
        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array
        List<Integer> students = new ArrayList<Integer>();
        for (double grade :
                temporalResultArray) {
            if (higher >= grade && lower < grade) {
                students.add(studentIdList[counter]);
            }
            counter++;
        }
        Object[] studentsArray = students.toArray();
        counter = 0;
        int[] finalStudentArray = new int[studentsArray.length];
        for (Object itemInt :
                studentsArray) {
            finalStudentArray[counter] = (int) itemInt;
            counter++;
        }
        return  finalStudentArray;
    }

    public static void main(String[] args) {
        var receiver = calculateGPA(new int[]{1001, 1002},
                new char[][]{{'A', 'A', 'A', 'B'}, {'A', 'B', 'B'} });
        var newReceiver = getStudentsByGPA(3.5, 3.80, new int[] {1001, 1002},
                new char[][]{{'A', 'A', 'A', 'B'}, {'A', 'B', 'B'} });
        for (var i:
             newReceiver) {
            System.out.println(i);
        }
    }

    /*
    * public class StudentUtil {


    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
		double[] gpaList = new double[studentIdList.length];
		int count = 0;

		for (char[] studentGrade : studentsGrades) {
			double gpa = 0.0;

			for (char grade : studentGrade) {
				if (grade == 'A') {
					gpa += 4.0;
				} else if (grade == 'B') {
					gpa += 3.0;
				} else if (grade == 'C') {
					gpa += 2.0;
				}
			}

			gpaList[count++] = gpa/studentGrade.length;
		}

		return gpaList;
	}


	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
		// If we are doing parameter validation, then it generally is
		// done at the beginning of the method. This way if any of the
		// parameters are invalid, we return without performing any
		// further processing
		if (lower < 0 || higher < 0 || lower > higher) {
			return null;
		}

		double[] gpaList = calculateGPA(studentIdList, studentsGrades);

		int count = 0;
		for (double gpa : gpaList) {
			if (gpa >= lower && gpa <= higher) {
				count++;
			}
		}

		int[] result = new int[count];
		int index = 0;
		for (int i = 0; i <  gpaList.length; i++) {
			if (gpaList[i] >= lower && gpaList[i] <= higher) {
				result[index++] = studentIdList[i];
			}
		}

		return result;
	}



}

    * */
}