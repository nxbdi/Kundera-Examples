/*
 * Copyright 2011 Impetus Infotech.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.impetus.kundera.examples.crossdatastore.pickr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class representing a photographer
 * 
 * @author amresh.singh
 */

@Entity
@Table(name = "PHOTOGRAPHER", schema = "Pickr")
public class PhotographerUni_1_M_1_M
{
    @Id
    @Column(name = "PHOTOGRAPHER_ID")
    private int photographerId;
    
    @Column(name = "PHOTOGRAPHER_NAME")
    private String photographerName;

    // Will be persisted locally
    @Embedded
    private PersonalData personalData;

    // One to many, will be persisted separately
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="PHOTOGRAPHER_ID")
    private List<AlbumUni_1_M_1_M> albums;   
    

    /**
	 * @return the photographerId
	 */
	public int getPhotographerId() {
		return photographerId;
	}

	/**
	 * @param photographerId the photographerId to set
	 */
	public void setPhotographerId(int photographerId) {
		this.photographerId = photographerId;
	}

	/**
     * @return the photographerName
     */
    public String getPhotographerName()
    {
        return photographerName;
    }

    /**
     * @param photographerName the photographerName to set
     */
    public void setPhotographerName(String photographerName)
    {
        this.photographerName = photographerName;
    }

    /**
     * @return the personalData
     */
    public PersonalData getPersonalData()
    {
        return personalData;
    }

    /**
     * @param personalData
     *            the personalData to set
     */
    public void setPersonalData(PersonalData personalData)
    {
        this.personalData = personalData;
    }

    /**
     * @return the albums
     */
    public List<AlbumUni_1_M_1_M> getAlbums()
    {
        return albums;
    }

    /**
     * @param albums
     *            the albums to set
     */
    public void addAlbum(AlbumUni_1_M_1_M album)
    {
        if (this.albums == null || this.albums.isEmpty())
        {
            this.albums = new ArrayList<AlbumUni_1_M_1_M>();
        }
        this.albums.add(album);
    }

}