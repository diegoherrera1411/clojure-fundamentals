(ns brave.body-symmetrizer-test
  (:require
    [clojure.test :refer [deftest testing is]]
    [brave.body-symmetrizer :as b.body-symmetrizer]))

(deftest symmetric-parts-test
  (testing "symmetric-parts"
    (is (= (b.body-symmetrizer/symmetric-parts 2 {:name "1-arm" :size 10})
           #{{:name "2-arm", :size 10} {:name "1-arm", :size 10}})
        "When part needs to be symmetrized")
    (is (= (b.body-symmetrizer/symmetric-parts 3 {:name "arm" :size 10})
           #{{:name "arm", :size 10}})
        "When part doesn't need to be symmetrized")))

(deftest symmetric-body-test
  (testing "symmetric-body"
    (is (= #{{:name "head" :size 1}
             {:name "1-arm" :size 10}
             {:name "2-arm" :size 10}}
           (set (b.body-symmetrizer/symmetric-body 2 [{:name "head" :size 1}
                                                      {:name "1-arm" :size 10}]))))))

