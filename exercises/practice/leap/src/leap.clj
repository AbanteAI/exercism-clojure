(ns leap)

(defn leap-year? [year]
  (and (or (= 0 (mod year 4))
           (and (= 0 (mod year 100))
                (= 0 (mod year 400))))
       (not (and (= 0 (mod year 100))
                 (not (= 0 (mod year 400)))))))
