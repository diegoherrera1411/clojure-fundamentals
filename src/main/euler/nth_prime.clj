(ns euler.nth-prime
  (:require [utils.numbers :as u.numbers]))

(defn sieve-bound [n]
  (let [log-n    (Math/log n)
        loglog-n (Math/log log-n)]
    (long (* n (+ log-n loglog-n)))))

(def problem-sieve-bound (sieve-bound 10001))

(comment
 (->> (u.numbers/memo-primes-until problem-sieve-bound)
      (take 10001)
      last))
