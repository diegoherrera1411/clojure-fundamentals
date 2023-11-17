(ns utils.numbers-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [utils.numbers :as u.numbers]))

(deftest divisible-by?-test
  (testing "divisible-by?"
    (is (= true (u.numbers/divisible-by? 15 30)) "When %2 is divisible by %1")
    (is (= false (u.numbers/divisible-by? 3 5)) "When %2 is not divisible by %1")))

(deftest divisible-by-any?-test
  (testing "divisible-by-any?"
    (is (= true (u.numbers/divisible-by-any? [3 5] 15)) "When %2 is divisible by all of %1")
    (is (= true (u.numbers/divisible-by-any? [3 17] 15)) "When %2 is divisible by a subset of %1")
    (is (= false (u.numbers/divisible-by-any? [2 4] 15)) "When %2 is not divisible by any of %1")
    (is (= false (u.numbers/divisible-by-any? nil 15)) "When %1 is empty")))
