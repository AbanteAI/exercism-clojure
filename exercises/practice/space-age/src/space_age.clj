(ns space-age)

(def EARTH_SECONDS 31557600)

(defn age-on-planet [seconds orbital-period]
  (/ seconds (* EARTH_SECONDS orbital-period)))

(defn on-mercury [seconds]
  (age-on-planet seconds 0.2408467))

(defn on-venus [seconds]
  (age-on-planet seconds 0.61519726))

(defn on-earth [seconds]
  (age-on-planet seconds 1.0))

(defn on-mars [seconds]
  (age-on-planet seconds 1.8808158))

(defn on-jupiter [seconds]
  (age-on-planet seconds 11.862615))

(defn on-saturn [seconds]
  (age-on-planet seconds 29.447498))

(defn on-uranus [seconds]
  (age-on-planet seconds 84.016846))

(defn on-neptune [seconds]
  (age-on-planet seconds 164.79132))
