(ns euler.even-fibonacci-sum-test
  (:require [clojure.test :refer [deftest testing is]]
            [euler.even-fibonacci-sum :as e.fibonacci]))

(deftest sum-even-fibonacci-below-test
  (testing "sum-even-fibonacci-below"
    (is (= 10 (e.fibonacci/sum-even-fibonacci-below 10)))
    (is (= 44 (e.fibonacci/sum-even-fibonacci-below 100)))))
