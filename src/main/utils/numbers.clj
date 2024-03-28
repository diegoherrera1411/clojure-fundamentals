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

(defn multiplicity [dividend divisor]
  (->> (iterate #(* divisor %) divisor)
       (take-while #(divisible-by? % dividend))
       count))

(defn multiples-outside-range? [n sorted-int-list]
  (let [last-int (or (last sorted-int-list) 0)]
    (< last-int (* 2 n))))

(defn distinct-and-divisible-by? [n num]
  (and (divisible-by? n num) (not= n num)))

(defn sieve
  [start-prime number-range]
  (let [first-new-prime (some #(when (< start-prime %) %) number-range)]
    (if (multiples-outside-range? start-prime number-range)
      number-range
      (recur first-new-prime (remove (partial distinct-and-divisible-by? start-prime) number-range)))))

(defn prime-numbers-until
  [number]
  (->> (inc number)
       (range 3)
       (sieve 2)
       (cons 2)))

(def memo-primes-until (memoize prime-numbers-until))
