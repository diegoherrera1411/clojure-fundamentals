(ns euler.multiples-sum
  (:require
    [utils.numbers :as u.numbers]))

(defn sum-multiples-3-or-5-below [n]
  (->> (range 1 n)
       (filter (partial u.numbers/divisible-by-any? [3 5]))
       (reduce +)))
