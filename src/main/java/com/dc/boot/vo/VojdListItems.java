package com.dc.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VojdListItems {
    private int id;
    private String searchKeywords;
    private String tradeName;
    private String productLink;
    private String coverPictureLink;
    private String price;
    private String evaluationOfTheNumber;
    private String theCommentsLink;
    private String businessName;
    private String theStoreLink;
    private String label;
    private String thePageNumber;
    private String theCurrentTime;
    private int key;
}
