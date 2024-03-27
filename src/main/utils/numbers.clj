(ns utils.numbers
  (:require [clojure.string :as c-str]))

(defn divisible-by? [potential-divisor n]
  (= 0 (mod n potential-divisor)))

(defn divisible-by-any? [numbers n]
  (reduce
   #(or %1 (divisible-by? %2 n))
   false
   numbers))

(defn palindrome? [number]
  (let [number-str (str (some-> number int))]
    (= number-str (c-str/reverse number-str))))

(defn has-n-digits? [digits number]
  (let [number-str (some-> number int str)]
    (= (count number-str) digits)))

(defn safe-divide [& args]
  (if-not (some nil? args)
    (apply / args)
    nil))

(safe-divide 1 2 nil)
(has-n-digits? 3 nil)
