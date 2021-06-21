(ns ui.markdown.viewer
  "markdown renderers are available as js library or react library
   we implemented a markdown viewer via a js library marked
   because the react component did not work.
   "
  (:require
   ["marked" :as marked]))

(defn ^{:category :ui}
  markdown-viewer
  "reagent markdown render component
   usage:
    [markdown markdown-string]"
  ([md]
   (markdown-viewer {} md))
  ([props md]
   (if (nil? md) ; marked will crash on (nil? md), so we catch nil. 
     [:p "Empty Markdown"]
     [:div.prose  ; marked converts md to html; .prose ensures standard browser tags are restored (tailwind resets them)
      (merge {:dangerouslySetInnerHTML {:__html (marked md)}}
             props)])))

;; awb99:
;; 
;; I tried two react components:
;; 
;; 1. terra-markdown
;;    ["terra-markdown" :as react-md]
;;    
;; 2. react-markdown
      ;["react-markdown" :as react-md]
   ; react-markdown requires npm dependency: 
   ; unist-util-visit ^1.3.0
   ; unist-util-visit-parents@^2.0.0

; https://github.com/niquola/md-to-hiccup
; https://github.com/jsa-aerial/md-to-hiccup/blob/master/src/md_to_hiccup/core.cljc

#_(defn markdown [md]
    [:div.gorilla-markdown
     [:> react-md {:src md :id "bongo"}]])

#_(println "react-md: " (pr-str react-md))

