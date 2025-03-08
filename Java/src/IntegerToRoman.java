public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
    public static String intToRoman(int num) {

        int firstChar = 0;
        int number = num,numOfDigs;
        StringBuilder numberAsRoman = new StringBuilder();
        while (number>0) {
            String numberAsString = Integer.toString(number);
            int firstDig = numberAsString.charAt(firstChar) - '0';
            if ((firstDig != 4) && (firstDig !=9)) {
                char romanChar = getMaxRomanCharThatCanBeReduced(number);
                numberAsRoman.append(romanChar);
                number = getReducedNum(number,romanChar);
            }
            else {
                numOfDigs = numberAsString.length();
                if (numOfDigs == 1 && firstDig == 4) {
                    numberAsRoman.append("IV");
                    number-=4;
                }
                else if (numOfDigs == 2 && firstDig == 4) {
                    numberAsRoman.append("XL");
                    number-=40;
                }
                else if (numOfDigs == 3 && firstDig == 4) {
                    numberAsRoman.append("CD");
                    number-=400;
                }
                else if (numOfDigs == 1 && firstDig == 9) {
                    numberAsRoman.append("IX");
                    number-=9;
                }
                else if (numOfDigs == 2 && firstDig == 9) {
                    numberAsRoman.append("XC");
                    number-=90;
                }
                else if (numOfDigs == 3 && firstDig == 9) {
                    numberAsRoman.append("CM");
                    number-=900;
                }

            }
        }
        return numberAsRoman.toString();
    }

    private static char getMaxRomanCharThatCanBeReduced(int num) {
        if (num-1000>=0) return 'M';
        else if (num-500>=0) return 'D';
        else if (num-100>=0) return 'C';
        else if (num-50>=0) return 'L';
        else if (num-10>=0) return 'X';
        else if (num-5>=0) return 'V';
        else if (num-1>=0) return 'I';

        else return '0';
    }

    private static int getReducedNum(int num, char roman) {
        if (roman=='I') return num-1;
        else if (roman=='V') return num-5;
        else if (roman=='X') return num-10;
        else if (roman=='L') return num-50;
        else if (roman=='C') return num-100;
        else if (roman=='D') return num-500;
        else if (roman=='M') return num-1000;
        else return num;
    }
}
