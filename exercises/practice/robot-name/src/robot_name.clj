(ns robot-name)
(:require [clojure.string :as str])
(:import (java.util.concurrent.atomic AtomicReference))

(defn- generate-random-name []
  (str (char (+ (rand-int 26) 65))
       (char (+ (rand-int 26) 65))
       (format "%03d" (rand-int 1000))))

(defn robot []
  (AtomicReference. {:name (generate-random-name)}))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot update :name (fn [_] (generate-random-name))))
