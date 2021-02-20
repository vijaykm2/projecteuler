package com.vijay.projecteuler.leetcode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IntegerToEnglishWords implements CommandLineRunner {
    String getThirdDigit(String number) {
        if (number.length() == 1) {
            return getFirstDigit(number);
        }
        if (number.length() == 2) {
            return getSecondDigit(number);
        }
        String secondDigit = number.substring(1);
        if (number.startsWith("1")) {
            return "One Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("2")) {
            return "Two Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("3")) {
            return "Three Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("4")) {
            return "Four Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("5")) {
            return "Five Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("6")) {
            return "Six Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("7")) {
            return "Seven Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("8")) {
            return "Eight Hundred " + getSecondDigit(secondDigit);
        } else if (number.startsWith("9")) {
            return "Nine Hundred " + getSecondDigit(secondDigit);
        } else {
            if (number.equals("000")) {
                return "";
            }
            return getSecondDigit(secondDigit);
        }
    }

    String getSecondDigit(String number) {
        if (number.startsWith("1")) {
            if (number.equals("10")) {
                return "Ten ";
            } else if (number.equals("11")) {
                return "Eleven ";
            } else if (number.equals("12")) {
                return "Twelve ";
            } else if (number.equals("13")) {
                return "Thirteen ";
            } else if (number.equals("14")) {
                return "Fourteen ";
            } else if (number.equals("15")) {
                return "Fifteen ";
            } else if (number.equals("16")) {
                return "Sixteen ";
            } else if (number.equals("17")) {
                return "Seventeen ";
            } else if (number.equals("18")) {
                return "Eighteen ";
            } else {
                return "Nineteen ";
            }
        } else if (number.startsWith("2")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Twenty ";
            } else {
                return "Twenty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("3")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Thirty ";
            } else {
                return "Thirty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("4")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Forty ";
            } else {
                return "Forty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("5")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Fifty ";
            } else {
                return "Fifty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("6")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Sixty ";
            } else {
                return "Sixty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("7")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Seventy ";
            } else {
                return "Seventy " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("8")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Eighty ";
            } else {
                return "Eighty " + getFirstDigit(firstDigit);
            }
        } else if (number.startsWith("9")) {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "Ninety ";
            } else {
                return "Ninety " + getFirstDigit(firstDigit);
            }
        } else {
            String firstDigit = number.substring(number.length() - 1);
            if (firstDigit.equals("0")) {
                return "";
            } else {
                return getFirstDigit(firstDigit);
            }
        }
    }

    private String getFirstDigit(String w) {
        w.length();
        String s = w.substring(w.length() - 1);
        String word = "";
        if (s.equals("0")) {
            word = "Zero ";
        } else if (s.equals("1")) {
            word = "One ";
        } else if (s.equals("2")) {
            word = "Two ";
        } else if (s.equals("3")) {
            word = "Three ";
        } else if (s.equals("4")) {
            word = "Four ";
        } else if (s.equals("5")) {
            word = "Five ";
        } else if (s.equals("6")) {
            word = "Six ";
        } else if (s.equals("7")) {
            word = "Seven ";
        } else if (s.equals("8")) {
            word = "Eight ";
        } else if (s.equals("9")) {
            word = "Nine ";
        }
        return word;
    }

    public String numberToWords(int num) {
        Integer input = num;
        String[] digits = input.toString().split("");

        List<String> hundreds = new ArrayList<>();
        StringBuilder hundred = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (hundred.length() == 3) {
                hundred.reverse();
                hundreds.add(hundred.toString());
                hundred = new StringBuilder();
            }
            hundred.append(digits[i]);
        }
        if (hundred.length() != 0) {
            hundred.reverse();
            hundreds.add(hundred.toString());
        }
        String result = "";
        for (int i = hundreds.size() - 1; i >= 0; i--) {
            String thirdDigit = getThirdDigit(hundreds.get(i));
            if(thirdDigit.equals("")){
                result += "";
            } else {

                if (i == 3) {
                    result += thirdDigit + "Billion ";
                }
                if (i == 2) {
                    result += thirdDigit + "Million ";
                }
                if (i == 1) {
                    result += thirdDigit + "Thousand ";
                }
                if (i == 0) {
                    result += thirdDigit;
                }
            }
        }

        return result.trim();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Integer to words: " + numberToWords(1000000));
    }
}
