/*
 * OpenBench LogicSniffer / SUMP project 
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110, USA
 *
 * Copyright (C) 2006-2010 Michael Poppitz, www.sump.org
 * Copyright (C) 2010 J.W. Janssen, www.lxtreme.nl
 */
package nl.lxtreme.ols.client.action;


import java.net.*;

import javax.swing.*;

import nl.lxtreme.ols.client.*;
import nl.lxtreme.ols.client.icons.*;


/**
 * 
 */
public abstract class BaseAction extends AbstractAction implements IconLocator, IManagedAction
{
  // CONSTANTS

  private static final long serialVersionUID = 1L;

  // VARIABLES

  private final String id;
  private final IClientController controller;

  // CONSTRUCTORS

  /**
   * Creates a new BaseAction instance with a compound icon.
   * 
   * @param aID
   *          the unique ID of this action, cannot be <code>null</code>;
   * @param aController
   *          the client controller this action can use, cannot be
   *          <code>null</code>;
   * @param aIcon
   *          the icon to use for this action, can be <code>null</code> if no
   *          icon is desired;
   * @param aName
   *          the name of this icon, cannot be <code>null</code>;
   * @param aDescription
   *          the description/tooltip of this action.
   */
  protected BaseAction( final String aID, final IClientController aController, final Icon aIcon, final String aName,
      final String aDescription )
  {
    super( aID );

    this.id = aID;
    this.controller = aController;

    putValue( NAME, aName );
    putValue( SHORT_DESCRIPTION, aDescription );

    if ( aIcon != null )
    {
      putValue( Action.LARGE_ICON_KEY, aIcon );
    }
  }

  /**
   * Creates a new BaseAction instance without an icon.
   * 
   * @param aID
   *          the unique ID of this action, cannot be <code>null</code>;
   * @param aController
   *          the client controller this action can use, cannot be
   *          <code>null</code>;
   * @param aName
   *          the name of this icon, cannot be <code>null</code>;
   * @param aDescription
   *          the description/tooltip of this action.
   */
  protected BaseAction( final String aID, final IClientController aController, final String aName,
      final String aDescription )
  {
    this( aID, aController, ( String )null /* aIconName */, aName, aDescription );
  }

  /**
   * Creates a new BaseAction instance with an icon.
   * 
   * @param aID
   *          the unique ID of this action, cannot be <code>null</code>;
   * @param aController
   *          the client controller this action can use, cannot be
   *          <code>null</code>;
   * @param aIconName
   *          the (symbolic) name of the icon to use for this action, can be
   *          <code>null</code> if no icon is desired;
   * @param aName
   *          the name of this icon, cannot be <code>null</code>;
   * @param aDescription
   *          the description/tooltip of this action.
   */
  protected BaseAction( final String aID, final IClientController aController, final String aIconName,
      final String aName, final String aDescription )
  {
    super( aID );

    this.id = aID;
    this.controller = aController;

    putValue( NAME, aName );
    putValue( SHORT_DESCRIPTION, aDescription );

    if ( aIconName != null )
    {
      final URL url = IconLocator.class.getResource( aIconName );
      putValue( Action.LARGE_ICON_KEY, new ImageIcon( url ) );
    }
  }

  // METHODS

  /**
   * @see nl.lxtreme.luna.ui.IManagedAction#getId()
   */
  @Override
  public String getId()
  {
    return this.id;
  }

  /**
   * Returns the client controller.
   * 
   * @return a client controller, never <code>null</code>.
   */
  protected final IClientController getController()
  {
    return this.controller;
  }
}

/* EOF */
