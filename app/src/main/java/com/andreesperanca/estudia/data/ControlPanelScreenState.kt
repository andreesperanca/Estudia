package com.andreesperanca.estudia.data

sealed class ControlPanelScreenState {
    object Study: ControlPanelScreenState()
    object ShortPause: ControlPanelScreenState()
    object LongPause: ControlPanelScreenState()
}

