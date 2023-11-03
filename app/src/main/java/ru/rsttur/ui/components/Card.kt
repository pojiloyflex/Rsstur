package ru.rsttur.ui.components

import BaseImage
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.rsttur.utils.CardType
import ru.rsttur.utils.formatNumber
import ru.rsttur.utils.getCurrencySymbol
import ru.rsttur.utils.getTypeOfDay

@Composable
fun BaseCard(url: String, title: String, subtitle: String, cardType: CardType) {
    if (CardType.HORIZONTAL == cardType) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            BaseImage(
                modifier = Modifier
                    .height(110.dp)
                    .width(110.dp),
                url = url
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 6.dp),
                    text = title,
                    fontWeight = FontWeight.ExtraBold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 15.sp,
                    maxLines = 1,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify
                )
                Text(
                    modifier = Modifier, text = subtitle,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    maxLines = 4,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .padding(3.dp)
                .height(180.dp)
                .width(155.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            BaseImage(
                modifier = Modifier
                    .height(100.dp)
                    .width(180.dp),
                url = url
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 2.dp), text = title,
                fontWeight = FontWeight.ExtraBold,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                maxLines = 1,
                lineHeight = 20.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = subtitle,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                maxLines = 2,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun RoomCard(
    url: String,
    title: String,
    touristCount: Int,
    price: Int,
    currency: String,
    dayType: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        BaseImage(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            url = url
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 6.dp),
                text = "До $touristCount гостей",
                fontWeight = FontWeight.ExtraBold,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                maxLines = 1,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = title,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                maxLines = 1,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = "От ${formatNumber(price)}${getCurrencySymbol(currency)}/ ${
                    getTypeOfDay(
                        dayType
                    )
                }",
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                maxLines = 1,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Composable
fun TourCard(
    title: String,
    imageLink: String,
    date: String,
    durationDay: Int,
    durationNight: Int,
    price: Int,
    home: String,
    currency: String,
    houseName: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        BaseImage(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp),
            url = imageLink
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 6.dp),
                text = "$date/$durationDay дней $durationNight ночей/$home($houseName)",
                fontWeight = FontWeight.Light,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                maxLines = 1,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = title,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                maxLines = 1,
                lineHeight = 16.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = "${formatNumber(price)}${getCurrencySymbol(currency)}",
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                maxLines = 1,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun BlogPreviewCard(
    id: Long,
    url: String,
    title: String,
    subtitle: String,
    views: Int,
    likes: Int,
    onBlogClicked: (Long, String) -> Unit
) {
    Row(
        modifier = Modifier
            .height(110.dp)
            .width(330.dp)
            .clickable {
                onBlogClicked(id, title)
            },
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BaseImage(
            modifier = Modifier
                .padding(top = 4.dp)
                .height(95.dp)
                .width(95.dp),
            url = url
        )
        Column(
            modifier = Modifier
        ) {
            Text(
                modifier = Modifier,
                text = title,
                fontWeight = FontWeight.ExtraBold,
                overflow = TextOverflow.Ellipsis,
                fontSize = 15.sp,
                maxLines = 1,
                lineHeight = 20.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = subtitle,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                maxLines = 4,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
            Text(
                modifier = Modifier,
                text = "Понравилось: $likes Просмотров: $views",
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                maxLines = 4,
                lineHeight = 18.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}



