package com.DBProject.auctionSystem.controller;

import com.DBProject.auctionSystem.model.Bid;
import com.DBProject.auctionSystem.model.Member;
import com.DBProject.auctionSystem.service.AuctionService;
import com.DBProject.auctionSystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/auctions")
public class AuctionController {
    @Autowired
    AuctionService auctionService;

    @GetMapping(path = "/allBids")
    public List<String> getAllBids() { // could do @PathVariable
        return auctionService.getAllBids();
    }
    @GetMapping(path = "/buyer/{buyerID}")
    public List<Bid> getBuyer(@PathVariable int buyerID) {
        return auctionService.getBidsByBuyerID(buyerID);
    }

    @GetMapping(path = "/item/{itemID}")
    public List<Bid> getItem(@PathVariable int itemID) {
        return auctionService.getBidsByItemID(itemID);
    }

    @PostMapping(path = "/addBid")
    public Bid add(@RequestBody Bid bid) {
        return auctionService.addBid(bid);
    }
}
