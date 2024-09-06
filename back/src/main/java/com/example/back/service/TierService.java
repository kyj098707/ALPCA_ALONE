package com.example.back.service;


import com.example.back.dto.ProductDto;
import com.example.back.dto.TierCreateDto;
import com.example.back.dto.TierListDto;
import com.example.back.entity.Member;
import com.example.back.entity.Product;
import com.example.back.entity.Tier;
import com.example.back.repository.ProductRepository;
import com.example.back.repository.TierRepository;
import com.example.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
@RequiredArgsConstructor
public class TierService {
    private final TierRepository tierRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;



    private void saveTierList(List<ProductDto> productDtos, String tierRank, Member member){
        if (productDtos == null) return;

        for (ProductDto productDto : productDtos) {
            Product product = productRepository.findById(productDto.getId());

            Tier tier = new Tier();

            tier.setProduct(product);
            tier.setMember(member);
            tier.setTier(tierRank);
            tierRepository.save(tier);
        }
    }

    public void createTier(TierCreateDto tierCreateDto, String username){

        Member member = userRepository.findByUsername(username);

        List<Tier> tiersToDelete = tierRepository.findByMember(member);
        if (!tiersToDelete.isEmpty()) {
            tierRepository.deleteAll(tiersToDelete);  // Member와 연결된 모든 Tier 삭제
        }
        saveTierList(tierCreateDto.getS(), "S", member);
        saveTierList(tierCreateDto.getA(), "A", member);
        saveTierList(tierCreateDto.getB(), "B", member);
        saveTierList(tierCreateDto.getC(), "C", member);
        saveTierList(tierCreateDto.getD(), "D", member);
    }

    public TierListDto readTierByUsername(String username) {

        Member member = userRepository.findByUsername(username);
        List<Tier> myTierList = tierRepository.findByMember(member);

        List<ProductDto> sTierList = new ArrayList<>();
        List<ProductDto> aTierList = new ArrayList<>();
        List<ProductDto> bTierList = new ArrayList<>();
        List<ProductDto> cTierList = new ArrayList<>();
        List<ProductDto> dTierList = new ArrayList<>();

        for (Tier myTier : myTierList) {
            String tier = myTier.getTier();
            Product product = myTier.getProduct();
            ProductDto productDto = new ProductDto(product);

            switch (tier.toUpperCase()) {
                case "S":
                    sTierList.add(productDto);
                    break;
                case "A":
                    aTierList.add(productDto);
                    break;
                case "B":
                    bTierList.add(productDto);
                    break;
                case "C":
                    cTierList.add(productDto);
                    break;
                case "D":
                    dTierList.add(productDto);
                    break;
                default:
                    continue;
            }

        }
        return new TierListDto(sTierList, aTierList, bTierList, cTierList, dTierList);
    }
}
