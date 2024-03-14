(ns euler.largest-prime-factor-test
  (:require [clojure.test :refer :all]
            [euler.largest-prime-factor :as e.lpf]))

(deftest largest-prime-factor-test
  (testing "largest prime factor"
    (is (= 29 (e.lpf/largest-prime-factor (* 29 3 2))))))


(deftest prime-numbers-until-test
  (testing "prime-numbers-until"
    (is (= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97)
           (e.lpf/prime-numbers-until 100)))))