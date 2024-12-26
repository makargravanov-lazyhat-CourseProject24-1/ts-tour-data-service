package ru.jetlabs.ts.tourdataservice.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.jetlabs.ts.tourdataservice.models.enums.RoomCapacity
import ru.jetlabs.ts.tourdataservice.models.enums.RoomType
import ru.jetlabs.ts.tourdataservice.service.HotelRoomsService

@RestController
@RequestMapping("/ts-tour-data-service/rooms")
class HotelRoomsController(
    val roomsService: HotelRoomsService
) {
    @GetMapping
    fun getRooms(
        @RequestParam hotelId: Long?,
        @RequestParam capacity: RoomCapacity?,
        @RequestParam type: RoomType?,
        @RequestParam wifi: Boolean?
    ): ResponseEntity<*> = roomsService.getRooms(hotelId = hotelId, capacity = capacity, type = type, wifi = wifi).let {
        ResponseEntity.status(HttpStatus.OK).body(it)
    }
}