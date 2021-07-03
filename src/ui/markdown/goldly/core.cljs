(ns ui.markdown.goldly.core
  (:require
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.markdown.viewer :refer [markdown-viewer]]
   [ui.markdown.goldly.prosemirror-atom :refer [prosemirror-atom]]))

(register-component :p/markdown markdown-viewer)
(register-component :p/prosemirror prosemirror-atom)

