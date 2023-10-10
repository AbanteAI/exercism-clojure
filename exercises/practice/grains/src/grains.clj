(ns grains)

(defn square [n]
    (long (Math/pow 2 (dec n)))
)

(defn total []
    (dec (long (Math/pow 2 64)))
)
