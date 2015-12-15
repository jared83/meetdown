(ns meetdown.corecljs
  (:require [petrol.core :as petrol]
            [reagent.core :as reagent]
            [meetdown.view :as view]))


(def initial-state
  {:event {:name ""}})

(defonce !app
  (reagent/atom initial-state))

;; figwheel reload-hook
(defn reload-hook
  []
  (swap! !app identity))

(defn render-fn
  [ui-channel app]
  (reagent/render-component [view/root ui-channel app]
                            js/document.body))

(defn ^:export main
  []
  (enable-console-print!)
  (petrol/start-message-loop! !app render-fn))
