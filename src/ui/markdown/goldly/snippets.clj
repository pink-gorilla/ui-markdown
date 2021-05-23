(ns ui.markdown.goldly.snippets
  (:require
   [systems.snippet-registry :refer [add-snippet]]))

; prosemirror examples are separate,
; because we want to be able to not load editor snippets 
; in normal goldly configurations.

(add-snippet {:type :pinkie
              :category :markdown
              :id :html-prose
              :filename "snippets/markdown/prose.edn"})

(add-snippet {:type :pinkie
              :category :markdown
              :id :markdown-viewer
              :filename "snippets/markdown/viewer.edn"})

(add-snippet {:type :goldly
              :category :markdown
              :id :markdown-viewer2
              :filename "snippets/markdown/viewer2.clj"})

(add-snippet {:type :goldly
              :category :markdown
              :id :markdown-editor
              :filename "snippets/markdown/prosemirror.edn"})