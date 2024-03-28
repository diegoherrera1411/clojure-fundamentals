(ns euler.smallest-multiple
  (:require [utils.numbers :as u.numbers]
            [euler.largest-prime-factor :as primes]))

(defn multiplicities-in-range [pn num-range]
  (map #(u.numbers/multiplicity % pn) num-range))

(defn smallest-multiple [n]
  (let [prime-nums     (primes/prime-numbers-until n)
        num-range      (range 1 (inc n))
        multiplicities (->> prime-nums
                            (map #(vector % (->> num-range (multiplicities-in-range %) (apply max))))
                            (into (sorted-map)))]
    (reduce-kv
     (fn [acc k v]
       (* acc (-> k (Math/pow v) long)))
     1
     multiplicities)))

(comment
 (smallest-multiple 10)
 (primes/prime-numbers-until 20)
 (range 1 21)
 (vec 1 2))
