(ns utils.numbers-test
  (:require
   [clojure.test :refer [deftest testing is are]]
   [utils.numbers :as u.numbers]))

(deftest divisible-by?-test
  (testing "When %2 is divisible by %1"
    (is (= true (u.numbers/divisible-by? 15 30))))
  (testing "When %2 is not divisible by %1"
    (is (= false (u.numbers/divisible-by? 3 5)))))

(deftest divisible-by-any?-test
  (testing "When %2 is divisible by all of %1"
    (is (= true (u.numbers/divisible-by-any? [3 5] 15))))
  (testing "When %2 is divisible by a subset of %1"
    (is (= true (u.numbers/divisible-by-any? [3 17] 15))))
  (testing "When %2 is not divisible by any of %1"
    (is (= false (u.numbers/divisible-by-any? [2 4] 15))))
  (testing "When %1 is empty"
    (is (= false (u.numbers/divisible-by-any? nil 15)))))

(deftest palindrome?-test
  (testing "nil case"
    (is (u.numbers/palindrome? nil)))
  (testing "When testing a palindrome"
    (is (u.numbers/palindrome? 123321)))
  (testing "When testing not palindrome"
    (is (not (u.numbers/palindrome? 123123)))))

(deftest has-n-digits?-test
  (testing "nil case"
    (are [has-digits? digits number]
      (= has-digits? (u.numbers/has-n-digits? digits number))
      true 0 nil
      false 1 nil))
  (testing "Number has n digits"
    (are [has-digits? digits number]
      (= has-digits? (u.numbers/has-n-digits? digits number))
      true 1 0
      true 3 124
      true 4 1234
      false 3 1234
      false 4 123)))
