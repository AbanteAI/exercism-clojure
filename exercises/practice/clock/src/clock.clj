(ns clock)

(defn clock->string [clock]
  (format "%02d:%02d" (mod (first clock) 24) (mod (second clock) 60)))

(defn clock [hours minutes]
  (let [total-minutes (+ (* hours 60) minutes)
        hours (quot (mod (+ (mod total-minutes 60) total-minutes) 1440) 60)
        minutes (mod total-minutes 60)]
    [hours minutes]))
(defn add-time [clock time]
  (let [total-minutes (+ (* (first clock) 60) (second clock) time)
        hours (quot (mod (+ (mod total-minutes 60) total-minutes) 1440) 60)
        minutes (mod total-minutes 60)]
    [hours minutes]))