/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2024-2024. All rights reserved.
 */

package study.json.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * 公共父类
 *
 * @since 2024/3/27
 **/
@Setter
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type",
    defaultImpl = PublicParent.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SonA.class, name = "a")
})
public class PublicParent {
    private String type;

    private String name;
}