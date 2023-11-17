(ns euler.multiples-sum-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [euler.multiples-sum :as e.multiples-sum]))

(deftest sum-multiples-3-or-5-below-test
  (testing "sum-multiples-3-or-5-below"
    (is (= 23 (e.multiples-sum/sum-multiples-3-or-5-below 10)) "Project Euler Sample")))
