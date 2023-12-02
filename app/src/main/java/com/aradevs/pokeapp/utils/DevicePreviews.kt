package com.aradevs.pokeapp.utils

import androidx.compose.ui.tooling.preview.Preview

/**
 * Multipreview annotation that represents various device sizes. Add this annotation to a composable
 * to render various devices.
 */
@Preview(device = "spec:width=411dp,height=891dp", name = "Phone")
@Preview(device = "spec:width=673.5dp,height=841dp,dpi=480", name = "Foldable")
@Preview(device = "spec:width=1280dp,height=800dp,dpi=480", name = "Tablet")
@Preview(device = "spec:width=1920dp,height=1080dp,dpi=480", name = "Desktop")
annotation class GenericPreviews

@Preview(device = "spec:width=800dp,height=1280dp,dpi=480", name = "Tablet Portrait")
annotation class TabletPortraitPreview

@Preview(device = "spec:width=1280dp,height=800dp,dpi=480", name = "Tablet Landscape", showBackground = true)
annotation class TabletLandscapePreview

@Preview(device = "spec:width=673.5dp,height=841dp,dpi=480", name = "Foldable Portrait")
annotation class FoldablePortraitPreview

@Preview(device = "spec:width=841dp,height=673.5dp,dpi=480", name = "Foldable Landscape")
annotation class FoldableLandscapePreview

@Preview(device = "spec:width=411dp,height=891dp", name = "Phone Portrait")
annotation class PhonePortraitPreview

@Preview(device = "spec:width=891dp,height=441dp", name = "Phone Landscape")
annotation class PhoneLandscapePreview